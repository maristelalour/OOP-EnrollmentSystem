package org.example.Service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.BeanProperty;

import static org.junit.jupiter.api.Assertions.*;
class TuitionFeePaymentTest {
    //arrange
    private TuitionFeePayment tuitionFeePayment;

    @BeforeEach
    void setup(){
        tuitionFeePayment = new TuitionFeePayment();
    }

    @Test
    @DisplayName("Calculate Tuition Fee")
    void shouldCalculateCorrectTuitionFeeWithNoDiscount(){

        //assert
        assertEquals(5000, tuitionFeePayment.calculateTuitionFee(5,0));
    }

    @Test
    void shouldCalculateCorrectTuitionFeeWithDiscount(){

        //assert
        assertEquals(4500, tuitionFeePayment.calculateTuitionFee(5,0.10));
    }

    @Test
    void shouldMakeAPaymentWorth500(){
        tuitionFeePayment.calculateTuitionFee(5,0); //pag wala 'to hindi mag rrun si makePayment kase calc first
        tuitionFeePayment.makePayment(500);

        //assert
        assertEquals(4500, tuitionFeePayment.getBalance());
    }

    @Test
    void shouldCheckIfFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(5,0);
        tuitionFeePayment.makePayment(5000);

        //assert
        assertTrue(tuitionFeePayment.isFullyPaid());
    }

    @Test
    void shouldCheckIfNotFullyPaid(){
        tuitionFeePayment.calculateTuitionFee(5,0);
        tuitionFeePayment.makePayment(400);

        //assert
        assertFalse(tuitionFeePayment.isFullyPaid());
    }

}