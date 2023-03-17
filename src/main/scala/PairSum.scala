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

  def func(number: Array[Int], sum: Int): Seq[(Int, Int)] = {
    number.foldLeft((Set.empty[Int], Seq.empty[(Int, Int)])){ case ((set, seq), el) =>
      val target = sum - el
      if (set.contains(target)) set -> (seq :+ (el, target))
      else (set + el) -> seq
    }._2
  }

  pairSumHashSet(Array[Int](2, 4, 7, 5, 9, 10, -1), 9)
  println(func(Array[Int](2, 4, 7, 5, 9, 10, -1), 9))
}
