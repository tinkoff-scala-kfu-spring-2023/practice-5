package ru.tinkoff.practice5

import scala.collection.mutable

object FindDuplicatesInArray extends App {
  private def removeDuplicateCollection(input: Array[Int]): Unit = {
    val set = mutable.TreeSet.empty[Int]
    for (i <- input) {
      set.add(i)
    }
    val output = Array.ofDim[Int](set.size)
    var count = 0
    val it = set.iterator
    while (it.hasNext) {
      output.update(count, it.next())
      count += 1
    }
    println(output.mkString(","))
  }

  removeDuplicateCollection(Array[Int](1, 2, 3, 4, 6, 5, 7, 7, 9, 8))
}
