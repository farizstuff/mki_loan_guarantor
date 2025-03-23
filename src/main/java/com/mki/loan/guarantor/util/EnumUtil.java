package com.mki.loan.guarantor.util;

import java.util.Arrays;
import java.util.Optional;

public class EnumUtil {

    public enum EnumVar {
        ACTIVE, INACTIVE, CHURNED, DEBIT, CREDIT;

        public static Optional<EnumVar> fromValue(String value) {
            if (value == null) {
                return Optional.empty();
            }
            try {
                return Optional.of(EnumVar.valueOf(value.toUpperCase()));
            } catch (IllegalArgumentException e) {
                return Optional.empty();
            }
        }

        public static boolean isValid(String value) {
            return fromValue(value).isPresent();
        }
    }

    public static boolean isValidEnum(String value) {
        return EnumVar.fromValue(value).isPresent();
    }
}
