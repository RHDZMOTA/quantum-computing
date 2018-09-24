package com.hdzco.quantumcomputing.simulation

import scala.math.{pow, sqrt}
import scala.util.Random

sealed trait QuantumSystem
object QuantumSystem {

  final case class Qubit(a: Double, b: Double, entangled: Option[Qubit.Entanglement] = None) extends QuantumSystem {
    val parameters: (Double, Double) = (a, b)
    val probabilities: (Double, Double) = (pow(a, 2), pow(b, 2))
    def tensorProduct(qubit: Qubit): QubitRegister.Two =
      QubitRegister.Two(a*qubit.a, a*qubit.b, b*qubit.a, b*qubit.b)
  }
  object Qubit {
    final case class Entanglement(zeroParams: (Double, Double), oneParams: (Double, Double)) {
      def forZero: Qubit  = Qubit(zeroParams._1, zeroParams._2)
      def forOne: Qubit   = Qubit(oneParams._1,  oneParams._2)
    }
    def zero: Qubit = Qubit(1, 0)
    def one: Qubit  = Qubit(0, 1)
    def random: QuantumSystem.Qubit = {
      val b = Random.nextDouble()
      val a = sqrt(1 - pow(b, 2))
      QuantumSystem.Qubit(a, b)
    }
  }

  sealed trait QubitRegister extends QuantumSystem
  object QubitRegister {
    final case class Two(a1a2: Double, a1b2: Double, b1a2: Double, b1b2: Double) extends QubitRegister {
      val parameters: (Double, Double, Double, Double) = (a1a2, a1b2, b1a2, b1b2)
      val (sa1a2, sa1b2, sb1a2, sb1b2) = (pow(a1a2, 2), pow(a1b2, 2), pow(b1a2, 2), pow(b1b2, 2))
      val probabilities: (Double, Double, Double, Double) = (sa1a2, sa1b2, sb1a2, sb1b2)
      val firstQubit: Qubit = {
        val a = sqrt(sa1a2 + sa1b2)
        val b = sqrt(sb1a2 + sb1b2)
        Qubit(a, b, Some(Qubit.Entanglement(
          (sqrt(sa1a2 / (sa1a2 + sa1b2)), sqrt(sa1b2 / (sa1a2 + sa1b2))),
          (sqrt(sb1a2 / (sb1a2 + sb1b2)), sqrt(sb1b2 / (sb1a2 + sb1b2)))
        )))}
      val secondQubit: Qubit = {
        val a = sqrt(sa1a2 + sb1a2)
        val b = sqrt(sa1b2 + sb1b2)
        Qubit(a, b, Some(Qubit.Entanglement(
          (sqrt(sa1a2 / (sa1a2 + sb1a2)), sqrt(sb1a2 / (sa1a2 + sb1a2))),
          (sqrt(sa1b2 / (sa1b2 + sb1b2)), sqrt(sb1b2 / (sa1b2 + sb1b2)))
        )))}
    }
  }

}
