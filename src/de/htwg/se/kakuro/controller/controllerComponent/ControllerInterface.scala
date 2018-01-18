package controller.controllerComponent

import GameStatus.GameStatus
import de.htwg.se.kakuro.model.fieldComponent.CellInterface

import scala.swing.Publisher

trait ControllerInterface extends Publisher {

  def gridSize: Int
  def createEmptyGrid(size: Int): Unit
  def undo(): Unit
  def redo(): Unit
  //def isSet(): Boolean
  //def resize(newSize: Int): Unit
  def cell(row: Int, col: Int): CellInterface
  def set(row: Int, col: Int, value: Int): Unit
  def set(row: Int, col: Int): Unit
  def set(row: Int, col: Int, rightSum: Int, downSum: Int): Unit
  def clear(row: Int, col: Int): Unit
  //def isSet(row: Int, col: Int): Boolean
  def isWhite(row: Int, col: Int): Boolean
  def showCandidates(row: Int, col: Int): Unit
  //def highlight(index: Int): Unit
  //def isHighlighted(row: Int, col: Int): Boolean
  def fieldToString: String
  def isShowCandidates(row: Int, col: Int): Boolean
  //def setShowCandidates(row: Int, col: Int): Unit
  //def unsetShowCandidates()
  def toggleShowAllCandidates(): Unit
  def showAllCandidates: Boolean
  def available(row: Int, col: Int): Set[Int]
  def gameStatus: GameStatus
  //def statusText: String
}

import scala.swing.event.Event

class CellChanged extends Event
case class GridSizeChanged(newSize: Int) extends Event
class CandidatesChanged extends Event