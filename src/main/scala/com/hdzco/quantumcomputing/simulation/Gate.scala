package com.hdzco.quantumcomputing.simulation

import QuantumSystem.{Qubit, QubitRegister}

object Gate {

  case class Cnot(control: QuantumSystem.Qubit, target: QuantumSystem.Qubit, register: QuantumSystem.QubitRegister.Two)

  def cnot(control: Qubit, target: Qubit): Cnot = {
    val qubitRegisterTwo = control tensorProduct target
    val cnotRegisterTwo = QubitRegister.Two(
      qubitRegisterTwo.a1a2, qubitRegisterTwo.a1b2, qubitRegisterTwo.b1b2, qubitRegisterTwo.b1a2)
    Cnot(cnotRegisterTwo.firstQubit, cnotRegisterTwo.secondQubit, cnotRegisterTwo)
  }
}
