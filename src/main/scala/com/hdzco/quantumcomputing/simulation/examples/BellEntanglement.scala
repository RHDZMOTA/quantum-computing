package com.hdzco.quantumcomputing.simulation.examples

import com.hdzco.quantumcomputing.simulation.{Gate, QuantumSystem, Transformation}

object BellEntanglement {

  def main(args: Array[String]): Unit = {

    // Alice and Bob have a Zero qubit
    val alice: QuantumSystem.Qubit = QuantumSystem.Qubit.zero
    val bob: QuantumSystem.Qubit   = QuantumSystem.Qubit.zero

    // Using the CNOT gate and Hadamard transform we can entangle Alice and Bob qubits.
    val aliceHadamard: QuantumSystem.Qubit = Transformation.hadamard(alice)
    val cnot = Gate.cnot(aliceHadamard, bob)
    val aliceControlQubit = cnot.control
    val bobTargetQubit    = cnot.target

    // Now we could collapse Alice's qubit first and automatically know Bob's qubit.
    val aliceCollapsedResults: Transformation.Collapsed = Transformation.collapse(aliceControlQubit)
    val aliceCollapsedQubit = aliceCollapsedResults.qubit
    val bobEntangledQubit   = aliceCollapsedResults.entangledQubit.get

    // Or we could collapse Bob's qubit first and automatically know Alice's qubit.
    val bobCollapsedResults: Transformation.Collapsed = Transformation.collapse(bobTargetQubit)
    val bobCollapsedQubit   = bobCollapsedResults.qubit
    val aliceEntangledQubit = bobCollapsedResults.entangledQubit.get

    println("Program output:")
    println("> Initial qubits: ")
    println("\t - Alice's qubit after hadamard:" + aliceHadamard)
    println("\t - Bob's qubit: " + bob)
    println("> Alice's and Bob's qubit after entanglement (dependent):")
    println("\t - Alice's control qubit: " + aliceControlQubit)
    println("\t - Bob's target qubit: " + bobTargetQubit)
    println("\t - Probabilities of (00 01 10 11) : " + cnot.register.probabilities)
    println("> Results if collapsing Alice's qubit first:")
    println("\t - Alice's collapsed qubit: " + aliceCollapsedQubit)
    println("\t - Bob's entangled qubit: " + bobEntangledQubit)
    println("> Results if collapsing Bob's qubit first:")
    println("\t - Bob's collapsed qubit: " + bobCollapsedQubit)
    println("\t - Alice's entangled qubit: " + aliceEntangledQubit)
  }
}
