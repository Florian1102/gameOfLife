package com.itf.training.gameOfLife;

public class Logic {

	Grid grid;
	private final char isAlive = 'o';
	private final char isDead = 0;

	public void startGame(int sizeOfGrid) {

		this.grid = new Grid(sizeOfGrid);

		this.grid.createGrid();
		this.grid.printGrid(grid);

		setSpecificCellAlive(1, 1, true);
		setSpecificCellAlive(2, 1, true);
		setSpecificCellAlive(2, 2, true);
		setSpecificCellAlive(1, 2, true);

		setSpecificCellAlive(3, 3, true);
		setSpecificCellAlive(3, 4, true);
		setSpecificCellAlive(4, 3, true);
		setSpecificCellAlive(4, 4, true);
		
		System.out.println();
		this.grid.printGrid(grid);

		System.out.println();
		
		for (int i = 0; i < 20; i++) {
			nextRound(sizeOfGrid);
		}
	}

	public void setSpecificCellAlive(int positionOfCellRow, int postitionOfCellColumn, boolean alive) {

		if (alive) {
			this.grid.setCell(positionOfCellRow, postitionOfCellColumn, isAlive);
		} else if (!alive) {
			this.grid.setCell(positionOfCellRow, postitionOfCellColumn, isDead);
		} else {
			System.out.println("No valid input");
		}

	}

	public void nextRound(int sizeOfGrid) {
		Grid newGrid = new Grid(sizeOfGrid);
		
		for (int i = 0; i < this.grid.getGrid().length; i++) {
			for (int j = 0; j < this.grid.getGrid().length; j++) {
				if (cellHaveToDie(i, j)) {
					newGrid.setCell(i, j, isDead);
				} else if (!cellHaveToDie(i, j)) {
					newGrid.setCell(i, j, isAlive);
				}
			}
		}
		
		grid = newGrid;
		this.grid.printGrid(grid);
		System.out.println();
		System.out.println("-----------");

	}

	public boolean cellHaveToDie(int row, int column) {
		if (!isCellAlive(row, column) && countLivingNeighbors(row, column) == 3) {
			return false;
		} else if (isCellAlive(row, column) && countLivingNeighbors(row, column) < 2) {
			return true;
		} else if (isCellAlive(row, column)
				&& (countLivingNeighbors(row, column) == 2 || countLivingNeighbors(row, column) == 3)) {
			return false;
		} else if (isCellAlive(row, column) && countLivingNeighbors(row, column) > 3) {
			return true;
		}
		return true;
	}

	public boolean isCellAlive(int rowOfCell, int columnOfCell) {

		if (rowOfCell < 0 || columnOfCell < 0 || rowOfCell >= this.grid.getGrid().length
				|| columnOfCell >= this.grid.getGrid().length) {
			return false;
		} else {
			return this.grid.getGrid()[rowOfCell][columnOfCell] == isAlive;
		}

	}

	public int countLivingNeighbors(int rowOfCell, int columnOfCell) {

		int counterCellsAlive = 0;

		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				if (!isMiddleCell(i, j)) {
					if (isCellAlive(rowOfCell + i, columnOfCell + j)) {
						counterCellsAlive++;
					}
				}
			}
		}
		return counterCellsAlive;
	}

	public boolean isMiddleCell(int offsetRow, int offsetColumn) {
		return offsetRow == 0 && offsetColumn == 0;
	}

}
