package ru.tinkoff.practice5

sealed trait IList[+A]
case object Nil extends IList[Nothing]
case class Cons[A](head: A, tail: IList[A]) extends IList[A]

object IList {
  def tail[A](list: IList[A]): IList[A] = ???

  def setHead[A](list: IList[A]): IList[A] = ???

  def drop[A](l: IList[A], n: Int): IList[A] = ???

  def dropWhile[A](l: IList[A], f: A => Boolean): IList[A] = ???

  def append[A](a1: IList[A], a2: IList[A]): IList[A] = ???

  def init[A](list: IList[A]): IList[A] = ???

  def foldRight[A, B](as: IList[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def length[A](as: List[A]): Int = ??? //with foldRight

  def foldLeft[A,B](as: IList[A], z: B)(f: (B, A) => B): B = ??? //should be tail-recursive

  def map[A,B](as: IList[A])(f: A => B): IList[B] = ???

  def filter[A](as: IList[A])(f: A => Boolean): IList[A] = ???

  def flatMap[A,B](as: IList[A])(f: A => IList[B]): IList[B] = ??? //Use flatMap to implement filter
}

