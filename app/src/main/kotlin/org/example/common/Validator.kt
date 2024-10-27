package org.example.common

class InputValidator {
    fun validateNonEmpty(input: String, fieldName: String){
        if(input.isEmpty()){
            throw IllegalArgumentException("$fieldName No debe estar vacio, requerido.")
        }
    }
    fun positiveNumber(input: Int, fieldName: String){
        if (input < 0 || input.toString().isEmpty()){
            throw IllegalArgumentException("$fieldName No acepta numeros negativos, requerido")
        }
    }
    fun validateRange(input: Int, fieldName: String, min: Int, max: Int){
        if(input < min || input > max){
            throw IllegalArgumentException("$fieldName debe estar entre $min, $max")
        }
    }
    fun validateNoNumbers(input: String, fieldName: String) {
        if (input.any { it.isDigit() }) {
            throw IllegalArgumentException("$fieldName no puede contener números.")
        }
    }
}