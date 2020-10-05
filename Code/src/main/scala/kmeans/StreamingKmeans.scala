package kmeans
package fun

object StreamingKmeans {

  // LoadImage - class Photo:
  val photo = new PhotoCanvas
  val image1 = photo.image

  // Method for Converged Image
  val imageIndex = new IndexedColorFilter(image1,20,RandomSampling,ConvergedAfterMeansAreStill(0.01))



  /*
  val kMeans = new KMeans()

  val seqtime = standardConfig measure {
    kMeans.kMeans(points, means, eta)
  }

  val parPoints = points.par
  val parMeans = means.par

  val partime = standardConfig measure {
    kMeans.kMeans(parPoints, parMeans, eta)
  }

  // Additional `println` to avoid bad interaction with JLine output
  println()
  println()
  println()
  println()
  println(s"sequential time: $seqtime")
  println(s"parallel time: $partime")
  println(s"speedup: ${seqtime.value / partime.value}")
  println()
  println()
  println()


   */
  // Save Image
  //val newMeans = kMeans.kMeans(points, means, eta)
  //val resultImg: Img = imageIndex.indexedImage(image1, newMeans)
  //saveFile("result1.png",resultImg)

}








