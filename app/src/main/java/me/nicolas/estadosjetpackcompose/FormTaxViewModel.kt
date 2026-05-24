package me.nicolas.estadosjetpackcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FormTaxViewModel : ViewModel() {
    var inputCantidad by mutableStateOf("")
    var inputPorcentaje by mutableStateOf("")
    var switchRedonder by mutableStateOf(false)

    val impuesto: String
        get() {
            val cantidad = inputCantidad.toDoubleOrNull() ?: 0.0
            val porcentaje = inputPorcentaje.toDoubleOrNull() ?: 0.0

            val impuesto = cantidad * porcentaje / 100
            val impuestoRedondeado = kotlin.math.ceil(impuesto)

            return if (switchRedonder) {
                impuestoRedondeado.toString()
            } else {
                impuesto.toString()
            }
        }

    fun updateCantidad(text: String) {
        inputCantidad = text
    }

    fun updatePorcentaje(text: String) {
        inputPorcentaje = text
    }

    fun updateSwitch(active: Boolean) {
        switchRedonder = active
    }
}
