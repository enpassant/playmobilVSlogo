package lego

import Api._

import scala.util.Random

object Lego extends App {
  val simpleSort = (numbers: List[Double]) => numbers.sorted
  val simpleCenter = (numbers: List[Double]) => numbers(numbers.length / 2)
  val simpleSample = (samplePercent: Double) => (numbers: List[Double]) => {
    val random = new Random
    numbers filter (n => random.nextDouble < samplePercent)
  }

  val calcMean = (sort: Transform, center: Algorithm) =>
    (numbers: List[Double]) => center(sort(numbers))
  val calcAverage = (numbers: List[Double]) => numbers.sum / numbers.length
  val calcMin = (numbers: List[Double]) => numbers.min
  val calcMax = (numbers: List[Double]) => numbers.max

  val testReadFn = (numbers: List[Double]) => (_: Unit) => numbers
  val testWriteFn = (label: String) =>
    (result: Double) => println(s"$label: $result")

  val processor = (read: Read, write: Write, algorithm: Algorithm) =>
    read andThen algorithm andThen write

  val testRead = testReadFn(List(2.4, 3.7, 9.5, 99.2, 8.7))

  val meanProcessor =
    processor(
      testRead,
      testWriteFn("Result (mean)"),
      calcMean(simpleSort, simpleCenter))

  val testProcessor = (label: String, algorithm: Algorithm) =>
    processor(testRead, testWriteFn(label), algorithm)

  val avgProcessor = testProcessor("Result (average)", calcAverage)
  val centerProcessor = testProcessor("Result (center)", simpleCenter)
  val sampleMeanProcessor = testProcessor("Result (sample mean)",
      simpleSample(0.5) andThen simpleSort andThen simpleCenter)
  val lengthProcessor = testProcessor("Result (length)", _.length)

  meanProcessor(Unit)
  avgProcessor(Unit)
  centerProcessor(Unit)
  sampleMeanProcessor(Unit)
  lengthProcessor(Unit)

  def log[I, O](fn: I => O)(input: I): O = {
    val stackTrace = Thread.currentThread().getStackTrace
    val label = stackTrace(2).getFileName + ":" + stackTrace(2).getLineNumber
    println(s"LOG [$label]. input: $input")
    val output = fn(input)
    println(s"LOG [$label]. output: $output")
    output
  }

  val sampleMean2Processor = testRead andThen
    log(simpleSample(0.5)) andThen
    log(simpleSort) andThen
    log(simpleCenter) andThen
    testWriteFn("Result (sampleMean2)")
  sampleMean2Processor(Unit)
}
