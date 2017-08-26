package btp.oneP;

public @interface Uniqueness {
	Constraints constrains() default @Constraints(unique=true);
}
