package com.knoldus

class ScoreCard(studentId: Int, totalMarks: Double, subject1: Double
                , subject2: Double, subject3: Double)


object ScoreCard {

  def apply(studentId: Int, totalMarks: Double, subject1: Double
            , subject2: Double, subject3: Double) = new ScoreCard(studentId, totalMarks, subject1
    , subject2, subject3)

  def totalMarks(subject1: Double, subject2: Double, subject3: Double):Double = subject1 +subject2+ subject3
  
}

