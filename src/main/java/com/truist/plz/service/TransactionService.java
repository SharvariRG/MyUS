package com.truist.plz.service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

@Service
public class TransactionService {
	final List<Object> values = new ArrayList<>();

	public Collection<Object> getValues(final Object root) throws ReflectiveOperationException {

		for (final Field field : getAllFields(root.getClass())) {
			field.setAccessible(true);
			final Object currentValue = field.get(root);
			field.setAccessible(false);
			if (currentValue != null) {
				if (ClassUtils.isPrimitiveOrWrapper(currentValue.getClass())
						|| currentValue.getClass().equals(String.class)) {
					values.add(currentValue);

				} else if (currentValue != null && currentValue instanceof Collection) {
					new ArrayList<>((Collection<?>) currentValue).forEach(obj -> {
						try {
							getValues(obj);
						} catch (ReflectiveOperationException e1) {
							e1.printStackTrace();
						}
					});

				} else if (currentValue != null) {

					getValues(currentValue);
				}
			} else {
				values.add("");
			}
		}
		return values;
	}

	private static Iterable<Field> getAllFields(Class<?> fromClass) {
		final List<Field> fields = new ArrayList<>();
		// while (fromClass != null) {
		fields.addAll(Arrays.asList(fromClass.getDeclaredFields()));
		// fromClass = fromClass.getSuperclass();
		// }
		return fields;
	}
}
