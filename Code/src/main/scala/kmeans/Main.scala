package kmeans
package fun

import java.awt.image.BufferedImage
import java.io.FileOutputStream

import javax.imageio.ImageIO


object Main extends App{

  def saveFile(path: String,image: Img): Unit = {
    val stream = new FileOutputStream(path)
    val bufferedImage = new BufferedImage(image.width, image.height, BufferedImage.TYPE_INT_ARGB)
    for (x <- 0 until image.width; y <- 0 until image.height) bufferedImage.setRGB(x, y, image(x, y))
    ImageIO.write(bufferedImage, "png", stream)
  }

  val imageClass = new PhotoCanvas

  val img = imageClass.image

  val result = new IndexedColorFilter(img,8,RandomSampling,ConvergedAfterNSteps(10))

  println(result.getStatus())
  val img_result = result.getResult()
  saveFile("result.png",img_result)


}
