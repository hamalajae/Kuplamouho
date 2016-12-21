package Kuplamouho

import scala.math._
import Kuplamouho._

class Bubble(val radius: Int, val startingLocation: (Int, Int), var verticalSpeed: Int) {
  
  var currentLocation = startingLocation
  var horizontalSpeed = 0
  
  def X = {
    currentLocation._1 - radius
  }
  
  def Y = {
    currentLocation._2 - radius
  }
  
  def move() = {
    currentLocation = (currentLocation._1 + verticalSpeed, currentLocation._2 + horizontalSpeed)
    horizontalSpeed += 1
  }
  
  def changeDirectionX() = verticalSpeed *= -1
  
  def changeDirectionY() = horizontalSpeed = -1 * (horizontalSpeed - 1)
  
}