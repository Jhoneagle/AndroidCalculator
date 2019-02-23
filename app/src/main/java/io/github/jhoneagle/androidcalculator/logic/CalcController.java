package io.github.jhoneagle.androidcalculator.logic;

import android.text.Editable;
import android.view.View;
import android.widget.TextView;

import io.github.jhoneagle.androidcalculator.R;

public class CalcController {
    private TextView input;
    private TextView output;
    private TextView output2;
    private TextView output3;
    private Evaluator evaluator;

    public CalcController(TextView input, TextView output, TextView output2, TextView output3) {
        this.input = input;
        this.output = output;
        this.output2 = output2;
        this.output3 = output3;
        this.evaluator = new Evaluator();

        clearAll();
    }

    public void add(View view) {
        switch (view.getId()) {
            case  R.id.buttonBrackets_close: {
                input.append(")");
                break;
            }
            case R.id.buttonBrackets_open: {
                input.append("(");
                break;
            }
            case  R.id.buttonTwo: {
                input.append("2");
                break;
            }
            case R.id.buttonThree: {
                input.append("3");
                break;
            }
            case  R.id.buttonTan: {
                input.append("tan(");
                break;
            }
            case R.id.buttonSquare: {
                input.append("^2");
                break;
            }
            case  R.id.buttonSix: {
                input.append("6");
                break;
            }
            case R.id.buttonSin: {
                input.append("sin(");
                break;
            }
            case  R.id.buttonSeven: {
                input.append("7");
                break;
            }
            case R.id.buttonRoot: {
                input.append("sqrt(");
                break;
            }
            case  R.id.buttonRemove: {
                String old = this.input.getText().toString();

                if (!old.isEmpty()) {
                    String substring = old.substring(0, (old.length() - 1));
                    this.input.setText(substring);
                }

                break;
            }
            case  R.id.buttonAbs: {
                input.append("abs(");
                break;
            }
            case  R.id.buttonPower: {
                input.append("^");
                break;
            }
            case R.id.buttonPii: {
                input.append("pi");
                break;
            }
            case  R.id.buttonOne: {
                input.append("1");
                break;
            }
            case R.id.buttonNine: {
                input.append("9");
                break;
            }
            case  R.id.buttonNepper: {
                input.append("e");
                break;
            }
            case R.id.buttonMultiply: {
                input.append("*");
                break;
            }
            case  R.id.buttonMinus: {
                input.append("-");
                break;
            }
            case R.id.buttonLog: {
                input.append("log(");
                break;
            }
            case  R.id.buttonLn: {
                input.append("ln(");
                break;
            }
            case R.id.buttonClear: {
                clearAll();
                break;
            }
            case R.id.buttonCos: {
                input.append("cos(");
                break;
            }
            case  R.id.buttonDivide: {
                input.append("/");
                break;
            }
            case R.id.buttonEight: {
                input.append("8");
                break;
            }
            case R.id.buttonFactorial: {
                input.append("!");
                break;
            }
            case  R.id.buttonFive: {
                input.append("5");
                break;
            }
            case R.id.buttonFour: {
                input.append("4");
                break;
            }
            case R.id.buttonZero: {
                input.append("0");
                break;
            }
            case R.id.buttonPlus: {
                input.append("+");
                break;
            }
            case  R.id.buttonResult: {
                double value = solveResult();

                if (!Double.isNaN(value)) {
                    String asString = value + "";
                    setNewValues(asString);
                } else {
                    setNewValues("NaN");
                }

                break;
            }
            case R.id.buttonReciprocal: {
                double value = solveResult();

                if (!Double.isNaN(value)) {
                    String asString = (1 / value) + "";
                    setNewValues(asString);
                } else {
                    setNewValues("NaN");
                }

                break;
            }
            case  R.id.buttonRAD: {
                double value = solveResult();

                if (!Double.isNaN(value)) {
                    String asString = Math.toRadians(value) + "";
                    setNewValues(asString);
                } else {
                    setNewValues("NaN");
                }

                break;
            }
            case  R.id.buttonDegree: {
                double value = solveResult();

                if (!Double.isNaN(value)) {
                    String asString = Math.toDegrees(value) + "";
                    setNewValues(asString);
                } else {
                    setNewValues("NaN");
                }

                break;
            }
            case R.id.buttonProsent: {
                double value = solveResult();

                if (!Double.isNaN(value)) {
                    String asString = (value / 100) + "";
                    setNewValues(asString);
                } else {
                    setNewValues("NaN");
                }

                break;
            }
            case R.id.buttonDot: {
                input.append(".");
                break;
            }
            default: {
                break;
            }
        }
    }

    private void clearAll() {
        this.output3.setText("");
        this.output2.setText("");
        this.output.setText("");
        this.input.setText("");
    }

    private double solveResult() {
        String equation = this.input.getText().toString();

        if (equation.isEmpty()) {
            return Double.NaN;
        } else {
            try {
                return this.evaluator.eval(equation);
            } catch (Exception e) {
                return Double.NaN;
            }
        }
    }

    private void setNewValues(String output) {
        this.output3.setText(this.output2.getText());
        this.output2.setText(this.output.getText());
        this.output.setText(output);
        this.input.setText("");
    }
}
