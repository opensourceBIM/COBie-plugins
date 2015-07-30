package org.bimserver.cobie.shared.utility;

import java.util.EnumSet;

public class EnumSetUtils
{
    public static int enumSetToInt(EnumSet<? extends org.bimserver.cobie.shared.utility.COBieIntConstantEnum> set)
    {
        int value = 0;

        for (org.bimserver.cobie.shared.utility.COBieIntConstantEnum flag : set)
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
