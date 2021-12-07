package com.example.demo.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.demo.databinding.ActivityCalculatorBinding
import com.example.demo.models.Numbers

class CalculatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCalculatorBinding
    lateinit var calculatorViewModel: CalculatorViewModel
    lateinit var numbersViewModel: NumbersViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalculatorBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        binding.btnClear.setOnClickListener(View.OnClickListener {
            binding.edtFirstNumber.text?.clear()
            binding.edtSecondNumber.text?.clear()
            binding.txtResultTitle.visibility = View.GONE
            binding.txtResult.text = ""
        })

        calculatorViewModel = ViewModelProvider(this)[CalculatorViewModel::class.java]


        /**
         * First method
         */
        /* binding.btnPlus.setOnClickListener(View.OnClickListener {

            try {
                val a = binding.edtFirstNumber.text.toString().toDouble()

                val b = binding.edtSecondNumber.text.toString().toDouble()

                calculatorViewModel.plusNumbers(a,b)
                calculatorViewModel.calculatorMutableLiveData.observe(this, Observer {

                    binding.txtResultTitle.visibility=View.VISIBLE
                    binding.txtResult.text= it.toString()


                })
            }catch ( e :Exception){
                Toast.makeText(this, "Please enter numbers in the fields", Toast.LENGTH_SHORT).show()
            }

         })*/
        /*  binding.btnMinus.setOnClickListener(View.OnClickListener {
             try {
                 val a = binding.edtFirstNumber.text.toString().toDouble()

                 val b = binding.edtSecondNumber.text.toString().toDouble()

                 calculatorViewModel.minusNumbers(a,b)
                 calculatorViewModel.calculatorMutableLiveData.observe(this, Observer {

                     binding.txtResultTitle.visibility=View.VISIBLE
                     binding.txtResult.text= it.toString()


                 })
             }catch (e:Exception){
                 Toast.makeText(this, "Please enter numbers in the fields", Toast.LENGTH_SHORT).show()

             }

          })*/
        /* binding.btnDivide.setOnClickListener(View.OnClickListener {
            try {
                val a = binding.edtFirstNumber.text.toString().toDouble()

                val b = binding.edtSecondNumber.text.toString().toDouble()

                calculatorViewModel.divideNumbers(a,b)
                calculatorViewModel.calculatorMutableLiveData.observe(this, Observer {

                    binding.txtResultTitle.visibility=View.VISIBLE
                    binding.txtResult.text= it.toString()


                })
            }catch (e:Exception){
                Toast.makeText(this, "Please enter numbers in the fields", Toast.LENGTH_SHORT).show()

            }
         })*/
        /*     binding.btnProduct.setOnClickListener(View.OnClickListener {
                try {
                    val a = binding.edtFirstNumber.text.toString().toDouble()

                    val b = binding.edtSecondNumber.text.toString().toDouble()

                    calculatorViewModel.productNumbers(a,b)
                    calculatorViewModel.calculatorMutableLiveData.observe(this, Observer {

                        binding.txtResultTitle.visibility=View.VISIBLE
                        binding.txtResult.text= it.toString()


                    })
                }catch (e:Exception){
                    Toast.makeText(this, "Please enter numbers in the fields", Toast.LENGTH_SHORT).show()

                }
             })*/


        /**
         * Second method : Using a data class for get and save the numbers
         */
        numbersViewModel = ViewModelProvider(this)[NumbersViewModel::class.java]
        binding.btnPlus.setOnClickListener(View.OnClickListener {

            try {
                val a = binding.edtFirstNumber.text.toString().toDouble()

                val b = binding.edtSecondNumber.text.toString().toDouble()

                numbersViewModel.getNumbers(Numbers(a, b))
                numbersViewModel.numbersMutableLiveData.observe(this, Observer {

                    it.let {
                        binding.txtResult.text = (it.firstNumber + it.secondNumber).toString()
                    }
                })

            } catch (e: Exception) {
                Toast.makeText(this, "Please enter numbers in the fields", Toast.LENGTH_SHORT)
                    .show()
            }

        })
        binding.btnMinus.setOnClickListener(View.OnClickListener {

            try {
                val a = binding.edtFirstNumber.text.toString().toDouble()

                val b = binding.edtSecondNumber.text.toString().toDouble()

                numbersViewModel.getNumbers(Numbers(a, b))
                numbersViewModel.numbersMutableLiveData.observe(this, Observer {

                    it.let {
                        binding.txtResult.text = (it.firstNumber - it.secondNumber).toString()
                    }
                })

            } catch (e: Exception) {
                Toast.makeText(this, "Please enter numbers in the fields", Toast.LENGTH_SHORT)
                    .show()
            }

        })
        binding.btnDivide.setOnClickListener(View.OnClickListener {

            try {
                val a = binding.edtFirstNumber.text.toString().toDouble()

                val b = binding.edtSecondNumber.text.toString().toDouble()

                numbersViewModel.getNumbers(Numbers(a, b))
                numbersViewModel.numbersMutableLiveData.observe(this, Observer {

                    it.let {
                        binding.txtResult.text = (it.firstNumber / it.secondNumber).toString()
                    }
                })

            } catch (e: Exception) {
                Toast.makeText(this, "Please enter numbers in the fields", Toast.LENGTH_SHORT)
                    .show()
            }

        })
        binding.btnProduct.setOnClickListener(View.OnClickListener {

            try {
                val a = binding.edtFirstNumber.text.toString().toDouble()

                val b = binding.edtSecondNumber.text.toString().toDouble()

                numbersViewModel.getNumbers(Numbers(a, b))
                numbersViewModel.numbersMutableLiveData.observe(this, Observer {

                    it.let {
                        binding.txtResult.text = (it.firstNumber * it.secondNumber).toString()
                    }
                })

            } catch (e: Exception) {
                Toast.makeText(this, "Please enter numbers in the fields", Toast.LENGTH_SHORT)
                    .show()
            }

        })


    }


}