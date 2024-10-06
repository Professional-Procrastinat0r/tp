package seedu.address.model.person;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.UUID;

/**
 * Represents a Person's employee id in the address book.
 * Guarantees: immutable; is always valid
 */
public class EmployeeId {
    public static final String MESSAGE_CONSTRAINTS =
            "Employee ID should only contain alphanumeric characters and hyphens in the format 8-4-4-4-12";

    public final String value;

    /**
     * Constructs an {@code EmployeeId}.
     *
     * @param remark A remark.
     */
    public EmployeeId(String employeeId) {
        requireNonNull(employeeId);
        checkArgument(isValidEmployeeId(employeeId), MESSAGE_CONSTRAINTS);
        value = employeeId;
    }

    /**
     * Generates a random UUID and constructs an {@code EmployeeId}.
     */
    public EmployeeId() {
        this(UUID.randomUUID().toString());
    }

    @Override
    public String toString() {
        return value;
    }

    /**
     * Returns true if a given string is a valid employee id.
     */
    public static boolean isValidEmployeeId(String test) {
        try {
            UUID.fromString(test);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof EmployeeId // instanceof handles nulls
                && value.equals(((EmployeeId) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
