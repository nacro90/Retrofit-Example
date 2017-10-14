package util;

import java.lang.reflect.Field;

public class StringUtils {
    
    public static String objectToString(Object object) {
        StringBuilder sb = new StringBuilder();
        sb.append(object.getClass().getSimpleName());
        sb.append(": \n");
        
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value = null;
            try {
                value = field.get(object);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                e.printStackTrace();
            }
            sb.append("\n");
            sb.append(field.getName());
            sb.append("=");
            if (value != null) {
                if (value instanceof String) {
                    sb.append("\"");
                    sb.append(value);
                    sb.append("\"");
                } else {
                    sb.append(value);
                }
            } else {
                sb.append("NULL");
            }
        }
        return sb.toString();
    }
}