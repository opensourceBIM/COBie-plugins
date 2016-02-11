package com.prairiesky.transform.template.meta;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelReference 

{
	String spreadsheetName() default "Product";
	String columnName() default "";
	public enum ColumnAddress
	{ A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, 
		R, S, T, U, V, W, X, Y, Z, AA, AB, AC, AD, AE, AF, AG, 
		AH, AI, AJ, AK, AL, AM, AN, AO, AP, AQ, AR, AS, AT, AU, AV, AW, AX, AY, AZ
	}
	
	ColumnAddress columnAddress() default ColumnAddress.A;
	
	boolean isForeignKey() default false;
	boolean isPrimaryKey() default false;
	
	String foreignKeySpreadsheetName() default "";
	String foreignKeyColumnName() default "";
	ColumnAddress foreignKeyColumnAddress() default ColumnAddress.A;

}
