package Kuplamouho

import processing.core._
import scala.collection.mutable.Buffer
import scala.collection.mutable.Map

object Kuplamouho extends PApplet {
  
  private val screenHeight = 500
  private val screenWidth = 800
  
  val player = (new Character(5, 400), loadImage("Character1.png"))
  val bubbleMap: Map[Bubble, PImage] = Map()
  
  bubbleMap(new Bubble(20, (100, 200), 5)) = loadImage("Kupla3.png")
  bubbleMap(new Bubble(40, (300, 100), 5)) = loadImage("Kupla3.png")
  
  def addBubble(bubble: Bubble, picture: PImage) = {
    bubbleMap(bubble) = picture
  }
  
  override def setup(): Unit = {
    size(screenWidth, screenHeight)
    frameRate(60)
  }
  
  override def draw(): Unit = {
    background(210, 140, 0)
    image(player._2, player._1.location, screenHeight - 80, player._2.width/10, player._2.height/10)
    bubbleMap.foreach( (par: (Bubble, PImage) ) => image(par._2, par._1.X, par._1.Y, (par._2.width * par._1.radius)/200, (par._2.height * par._1.radius)/200) )
    bubbleMap.keys.foreach((bubble: Bubble) => bubble.move())
    bubbleMap.keys.foreach((bubble: Bubble) => if(bubble.X + 2 * bubble.radius >= screenWidth || bubble.X  <= 0) bubble.changeDirectionX())
    bubbleMap.keys.foreach((bubble: Bubble) => if(bubble.Y + 2 * bubble.radius >= screenHeight || bubble.Y <= 0) bubble.changeDirectionY())
  }
  
  def main(args: Array[String]) {
    val frame = new javax.swing.JFrame("Kuplamouho")

    frame.getContentPane().add(this)
    init
    frame.setSize(this.getSize())
    frame.pack
    frame.setVisible(true)
    frame.setLocationRelativeTo(null)
    frame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE)
  }
  
}