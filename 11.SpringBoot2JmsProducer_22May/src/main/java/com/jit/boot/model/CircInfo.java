package com.jit.boot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CircInfo {

	private String matchId;
	private String op1;
	private String op2;
	private Integer op1Score;
	private Integer op2Score;
	private String winner;
}
