package com.itf.training.gameOfLife;

public class Grid {

	private char[][] grid;
	

	public Grid(int size) {
		this.grid = new char[size][size];
	}
	
		
	public char[][] getGrid() {
		return grid;
	}
	
	public void setGrid(char[][] grid) {
		this.grid = grid;
	}
	
	public void setCell(int positionOfCellRow, int postitionOfCellColumn, char isALiveOrIsDead) {
		this.grid[positionOfCellRow][postitionOfCellColumn] = isALiveOrIsDead;
	}
	
	public void createGrid() {
		
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				grid[i][j] = 0;
			}
		}
	}
	
	public void printGrid(Grid grid) {
		
		for (int i = 0; i < grid.grid.length; i++) {
			System.out.println();
			for (int j = 0; j < grid.grid.length; j++) {
				System.out.print(grid.grid[i][j] );
			}
		}
		
	}
	
	
}
