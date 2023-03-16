package ru.tinkoff.practice5

import scala.collection.mutable

object PairSum extends App {

  def pairSumHashSet(number: Array[Int], sum: Int): Unit = {
    val set = mutable.HashSet.empty[Int]
    for (value <- number) {
      val target = sum - value
      if (!set.contains(target)) set.add(value)
      else System.out.printf("(%d,%d) %n", value, target)
    }
  }

  pairSumHashSet(Array[Int](2, 4, 7, 5, 9, 10, -1), 9)
}
