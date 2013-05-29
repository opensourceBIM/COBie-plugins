package org.erdc.cobie.shared.utils;

import java.util.EnumSet;

import org.erdc.cobie.shared.COBieUtility;

public class EnumSetUtils
{
    public static int enumSetToInt(EnumSet<? extends org.erdc.cobie.shared.enums.COBieIntConstantEnum> set)
    {
        int value = 0;

        for (org.erdc.cobie.shared.enums.COBieIntConstantEnum flag : set)
        {
            value |= flag.toInt();
        }

        return value;
    }

    public static String enumSetToString(EnumSet<? extends Enum<?>> set)
    {
        String flags = "";

        for (Object flag : set)
        {
            if (!COBieUtility.isNullOrEmpty(flags))
            {
                flags += " | ";
            }

            flags += flag.toString();
        }

        return flags;
    }
}
