package org.luban.common.exception;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 异常工具类
 */
public abstract class Exceptions {

    /**
     * 获取错误信息
     *
     * @param e 异常
     * @return 错误信息
     */
    public static String getError(final Throwable e) {
        return getError(e, true, 0);
    }

    /**
     * 获取错误信息
     *
     * @param e         异常
     * @param trace     是否打印堆栈信息
     * @param maxLength 最大长度
     * @return 错误信息
     */
    public static String getError(final Throwable e, final boolean trace, final int maxLength) {
        if (e == null) {
            return "";
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        try {
            if (!trace) {
                pw.append(e.getMessage());
            } else {
                e.printStackTrace(pw);
            }
            pw.flush();
        } finally {
            pw.close();
        }
        String result = sw.toString();
        if (maxLength > 0) {
            if (maxLength >= result.length()) {
                return result;
            }
            return result.substring(0, maxLength);
        }
        return result;
    }

    /**
     * 查找原因
     *
     * @param e     异常
     * @param clazz 异常类型
     * @return 异常
     */
    public static Throwable getCause(Throwable e, Class<?> clazz) {
        if (e == null || clazz == null) {
            return null;
        }
        Throwable cause = e;
        while (cause != null) {
            if (cause.getClass().equals(clazz)) {
                return cause;
            }
            cause = cause.getCause();
        }
        return null;
    }
}
