package Kuplamouho

class Character(val lives: Int, startingLocation: Int) {
  
  private var isAlive = true
  private var currentLocation = startingLocation
  
  def isDead = !isAlive
  
  def location = currentLocation
  
}