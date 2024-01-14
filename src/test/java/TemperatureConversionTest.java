import org.assertj.core.api.Assertions;
import org.fasttrackit.ex1.TemperatureConversion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TemperatureConversionTest {
    private TemperatureConversion temperatureConversion;

    @BeforeEach
    public void beforeEach(){
        this.temperatureConversion = new TemperatureConversion();
    }

    @Test
    @DisplayName("WHEN temperature is given in Fahrenheit THEN it is correctly converted to Celsius")
    public void fahrenheitToCelsiusTest(){
        //GIVEN
        double tempInFahrenheit = 100;

        //WHEN
        double result = temperatureConversion.fahrenheitToCelsius(tempInFahrenheit);

        //THEN
        Assertions.assertThat(result).isEqualTo(37.777777778);
    }

    @Test
    public void fahrenheitToCelsiusIfZeroTest(){
        //GIVEN
        double tempInFahrenheit = 0;

        //WHEN
        double result = temperatureConversion.fahrenheitToCelsius(tempInFahrenheit);

        //THEN
        Assertions.assertThat(result).isEqualTo(-17.777777778);
    }


    @Test
    @DisplayName("WHEN temperature is given in Celsius THEN it is correctly converted to Fahrenheit")
    public void celsiusToFahrenheitTest(){
        //GIVEN
        double tempInCelsius = 20;

        //WHEN
        double result = temperatureConversion.celsiusToFahrenheit(tempInCelsius);

        //THEN
        Assertions.assertThat(result).isEqualTo(68);
    }
}
