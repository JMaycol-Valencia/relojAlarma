package com.example.relojalarma

import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextClock

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TemporizadorFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TemporizadorFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var textClock: TextClock
    private lateinit var handler: Handler
    private var secondsElapsed: Int = 0
    private var timerRunning: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_temporizador, container, false)

        // Obtener una referencia al TextClock
        textClock = view.findViewById(R.id.textClock)

        // Establecer el formato de hora deseado
        textClock.format24Hour = "mm:ss"

        // Obtener una referencia a los botones de inicio y detención del temporizador
        val startButton = view.findViewById<Button>(R.id.startButton)
        val stopButton = view.findViewById<Button>(R.id.stopButton)

        // Agregar un listener al botón de inicio del temporizador
        startButton.setOnClickListener {
            // Iniciar el temporizador si no está corriendo
            if (!timerRunning) {
                startTimer()
                timerRunning = true
            }
        }

        // Agregar un listener al botón de detención del temporizador
        stopButton.setOnClickListener {
            // Detener el temporizador si está corriendo
            if (timerRunning) {
                stopTimer()
                timerRunning = false
            }
        }

        // Retornar la vista del fragmento
        return view
    }

    private fun startTimer() {
        // Crear el Handler
        handler = Handler(Looper.getMainLooper())

        // Ejecutar un Runnable en el Handler cada segundo
        handler.post(object : Runnable {
            override fun run() {
                // Incrementar los segundos transcurridos
                secondsElapsed++

                // Actualizar el TextClock
                textClock.text = String.format("%02d:%02d:%02d", secondsElapsed / 3600, (secondsElapsed % 3600) / 60, secondsElapsed % 60)

                // Ejecutar de nuevo el Runnable después de 1 segundo
                handler.postDelayed(this, 1000)
            }
        })
    }

    private fun stopTimer() {
        // Eliminar el Runnable del Handler para detener el temporizador
        handler.removeCallbacksAndMessages(null)

        // Reiniciar los segundos transcurridos
        secondsElapsed = 0

        // Actualizar el TextClock con el tiempo por defecto (00:00:00)
        textClock.text = "00:00:00"
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment TemporizadorFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            TemporizadorFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}