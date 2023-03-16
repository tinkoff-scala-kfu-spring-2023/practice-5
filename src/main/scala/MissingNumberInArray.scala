package ru.tinkoff.practice5

object MissingNumberInArray extends App {
  private def printMissingNumber(input: Array[Int], totalCount: Int): Unit = {
    val expectedSum = totalCount * (totalCount + 1) / 2
    var actualSum = 0
    for (i <- input.indices) {
      actualSum += input(i)
    }
    System.out.println("Missing number is " + (expectedSum - actualSum))
  }

  printMissingNumber(Array[Int](1, 2, 3, 5, 6), 6)
}
