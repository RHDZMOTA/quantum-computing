package com.hdzco.quantumcomputing.simulation

import scala.math.{pow, sqrt}
import scala.util.Random
import com.hdzco.quantumcomputing.simulation.QuantumSystem.Qubit

object Transformation {

  final case class Collapsed(qubit: Qubit, entangledQubit: Option[Qubit])
  def collapse(qubit: Qubit): Collapsed =
    if (Random.nextDouble() < pow(qubit.a, 2)) Collapsed(Qubit(1,0), qubit.entangled.map(_.forZero))
    else Collapsed(Qubit(0, 1), qubit.entangled.map(_.forOne))

  def hadamard(qubit: Qubit): Qubit =
    Qubit((qubit.a + qubit.b) / sqrt(2), (qubit.a - qubit.b) / sqrt(2),   qubit.entangled)

  def X(qubit: Qubit): Qubit =
    Qubit(qubit.b, qubit.a, qubit.entangled)

  def Z(qubit: Qubit): Qubit =
    Qubit(qubit.a, -qubit.b, qubit.entangled)
}
