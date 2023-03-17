package ru.tinkoff.practice5

sealed trait IList[+A]
case object Nil extends IList[Nothing]
case class Cons[A](head: A, tail: IList[A]) extends IList[A]

object IList {
  def tail[A](list: IList[A]): IList[A] = list match {
    case Nil => Nil
    case Cons(_, tail) => tail
  }

  def setHead[A](list: IList[A], el: A): IList[A] = list match {
    case Nil => Cons(el, Nil)
    case Cons(_, tail) => Cons(el, tail)
  }

  def drop[A](l: IList[A], n: Int): IList[A] = l match {
    case Nil => Nil
    case Cons(_, tail) => if (n == 0) tail else drop(tail, n - 1)
  }

  def dropWhile[A](l: IList[A], f: A => Boolean): IList[A] = l match {
    case Nil => Nil
    case Cons(head, tail) => if (f(head)) dropWhile(tail, f) else tail
  }

  def append[A](a1: IList[A], a2: IList[A]): IList[A] = a1 match {
    case Nil => a2
    case Cons(head, tail) => Cons(head, append(tail, a2))
  }

  def init[A](list: IList[A]): IList[A] = list match {
    case Nil => Nil
    case Cons(_, Nil) => Nil
    case Cons(head, tail) => Cons(head, init(tail))
  }

  def foldRight[A, B](as: IList[A], z: B)(f: (A, B) => B): B =
    as match {
      case Nil => z
      case Cons(x, xs) => f(x, foldRight(xs, z)(f))
    }

  def length[A](as: IList[A]): Int = foldRight(as, 0)((_, acc) => acc + 1) //with foldRight

  def foldLeft[A,B](as: IList[A], z: B)(f: (B, A) => B): B =
    as match {
      case Nil => z
      case Cons(head, tail) => foldLeft(tail, f(z, head))(f)
    } //should be tail-recursive

  def map[A,B](as: IList[A])(f: A => B): IList[B] =
    foldRight(as, Nil:IList[B])((a, b) => Cons(f(a), b))

  def filter[A](as: IList[A])(f: A => Boolean): IList[A] =
    foldRight(as, Nil: IList[A])((a, b) => if (f(a)) Cons(a, b) else b)

  def flatMap[A,B](as: IList[A])(f: A => IList[B]): IList[B] =
    foldLeft(as, Nil: IList[B])((acc, a) => append(acc, f(a)))
  //Use flatMap to implement filter
}

