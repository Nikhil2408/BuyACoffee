package com.example.buyacoffee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity
{
    int numberOfCoffeesOrdered=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view)
    {
        displayPrice(numberOfCoffeesOrdered*5);
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number)
    {
        String orderPlacedMsgPre="Total is ";
        String orderPlacedMsgPost="Thank You for ordering!!";
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(orderPlacedMsgPre+NumberFormat.getCurrencyInstance().format(number)+". "+orderPlacedMsgPost);
    }

    public void doIncrement(View view)
    {
        numberOfCoffeesOrdered=numberOfCoffeesOrdered+1;
        display(numberOfCoffeesOrdered);
    }

    public void doDecrement(View view)
    {
        if(numberOfCoffeesOrdered>0)
        {
            numberOfCoffeesOrdered=numberOfCoffeesOrdered-1;
            display(numberOfCoffeesOrdered);
        }
    }
}