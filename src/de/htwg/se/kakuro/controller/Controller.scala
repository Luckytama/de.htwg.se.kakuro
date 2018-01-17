package de.htwg.se.kakuro.controller

import de.htwg.se.kakuro.model.{ Cell, Field, FieldCreator }
import de.htwg.se.kakuro.util.{ Observable, UndoManager }

import scala.swing.Publisher
import org.apache.logging.log4j.Logger
import org.apache.logging.log4j.LogManager

class Controller(var field: Field) extends ControllerInterface with Publisher {
  var logger = LogManager.getLogger(this.getClass.getName)

  var undoManager = new UndoManager
  //var gameStatus: GameStatus = IDLE
  /*
  def undoField: Boolean = {
    field = undoManagerField.undoStepF
    true
  }*/

  def controllerUndo: Boolean = {
    //val grid = undoManager.undoField
    return true
  }
  def controllerRedo: Boolean = {
    //undoManager.redoStep
    return true
  }

  def initField(): Field = {
    var samplefield = new FieldCreator()
    field = samplefield.createEmptyGrid(8)
    field = samplefield.createSampleField(field)
    //undoManager.addField(this.field.grid)
    field
  }

  def set(row: Int, col: Int, value: Int): Boolean = {
    //undoManager.doStep(new SetCommand(row, col, value, this.field, this.undoManager))
    var wCell = field.cell(row, col).whiteCell
    logger.debug("set() row: " + row.toString() + " col: " + col.toString()
      + " value:" + value.toString() + " whiteCell: " + wCell)
    if (wCell
      && isValidInput(row)
      && isValidInput(col)
      && isValidInput(value)) {
      field.cell(row, col).whiteCellValue = value
      //undoManager.addField(this.field.grid)
      return true
    }
    false
  }

  def delete(row: Int, col: Int): Boolean = {
    var wCell = field.cell(row, col).whiteCell
    logger.debug("delete() row: " + row.toString() + " col: " + col.toString() + " whiteCell: " + wCell)
    if (wCell
      && isValidInput(row)
      && isValidInput(col)) {
      field.cell(row, col).whiteCellValue = 0
      return true
    }
    false
  }

  def isValidInput(input: Int): Boolean = {
    logger.debug("isValidInput, input: " + input.toString())
    if (input >= 1 && input <= 9) true
    else false
  }

}
