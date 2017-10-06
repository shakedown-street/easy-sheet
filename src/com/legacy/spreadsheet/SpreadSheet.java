package com.legacy.spreadsheet;

import java.awt.Color;
import java.awt.Graphics;

import com.legacy.ui.UserInterface;
import com.legacy.util.Utils;

public class SpreadSheet {

	private Cell[][] cells;
	private int cols, rows;
	private int selectedCol, selectedRow;
	private UserInterface ui;

	public static final Color BACK_COLOR = new Color(0, 0, 00, 255);
	public static final Color NORMAL_COLOR = new Color(180, 180, 180, 255);
	public static final Color SELECT_COLOR = new Color(25, 180, 70, 255);

	public SpreadSheet(UserInterface ui, int cols, int rows) {
		this.ui = ui;
		this.cols = cols;
		this.rows = rows;
		this.selectedCol = 0;
		this.selectedRow = 0;
		this.cells = new Cell[cols][rows];

		clear();
	}

	public void drawHeader(Graphics g, int x, int y) {
		g.setColor(NORMAL_COLOR);

		for (int c = 0; c < cols; c++) {
			int spreadX = x + (c * 90) + 83;

			if (c == getSelectedCol()) {
				g.setColor(SELECT_COLOR);
			}

			g.drawString(Utils.alphabetSearch(c), spreadX, y);
			g.setColor(NORMAL_COLOR);
		}

		for (int r = 0; r < rows; r++) {
			int spreadY = y + (r * 16) + 24;

			if (r == getSelectedRow()) {
				g.setColor(SELECT_COLOR);
			}

			g.drawString(r + 1 + "", x, spreadY);
			g.setColor(NORMAL_COLOR);
		}
	}

	public void draw(Graphics g, int x, int y) {
		drawHeader(g, x, y);
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				Cell cell = cells[c][r];
				int spreadX = x + (c * 90) + 45;
				int spreadY = y + (r * 16) + 24;

				g.setColor(NORMAL_COLOR);

				if (cell.equals(getSelectedCell())) {
					g.setColor(SELECT_COLOR);
					g.drawRect(spreadX - 2, spreadY - 10, 88, 13);
				}

				// Cell Value
				g.drawString(cell.getValue(), spreadX, spreadY);
			}
		}
		
		g.setColor(NORMAL_COLOR);
		g.fillRect(ui.getWidth() - 120, 0, 120, 26);
		g.setColor(BACK_COLOR);
		g.drawString("Sheet # of #", ui.getWidth() - 118, 16);

	}

	// ============================================//

	public void resize(int newCols, int newRows) {
		this.cols = newCols;
		this.rows = newRows;

		cells = new Cell[cols][rows];
		clear();
	}

	public void clear() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				cells[c][r] = new Cell(Utils.alphabetSearch(c) + (r + 1));
				setSelectedCell(0, 0);
			}
		}
	}

	// ============================================//

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getSelectedCol() {
		return selectedCol;
	}

	public void setSelectedCol(int selectedCol) {
		this.selectedCol = selectedCol;
	}

	public int getSelectedRow() {
		return selectedRow;
	}

	public void setSelectedRow(int selectedRow) {
		this.selectedRow = selectedRow;
	}

	public void incrementSelectedCol() {
		if (selectedCol + 1 >= this.cols) {
			return;
		}
		this.selectedCol++;
	}

	public void incrementSelectedRow() {
		if (selectedRow + 1 >= this.rows) {
			return;
		}
		this.selectedRow++;
	}

	public void decrementSelectedCol() {
		if (selectedCol - 1 < 0) {
			return;
		}
		this.selectedCol--;
	}

	public void decrementSelectedRow() {
		if (selectedRow - 1 < 0) {
			return;
		}
		this.selectedRow--;
	}

	public Cell getCell(int col, int row) {
		try {
			return cells[col][row];
		} catch (Exception e) {
			return null;
		}
	}

	public Cell getCell(String col, int row) {
		try {
			return cells[Utils.alphabetSearch(col)][row];
		} catch (Exception e) {
			return null;
		}
	}

	public Cell getCell(String reference) {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < cols; c++) {
				if (cells[c][r].getReference().equalsIgnoreCase(reference)) {
					return cells[c][r];
				}
			}
		}
		return null;
	}

	public Cell getSelectedCell() {
		return getCell(selectedCol, selectedRow);
	}

	public void setSelectedCell(int col, int row) {

		if (col < 0 || col >= cols) {
			return;
		}
		if (row < 0 || row >= rows) {
			return;
		}

		this.selectedCol = col;
		this.selectedRow = row;
	}

}
