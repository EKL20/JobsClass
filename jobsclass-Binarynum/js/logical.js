/**
 * Desde decimal a otras bases
 * @author Elkin Londoño
 */


function converNumber() {
    // Este número lo iremos convirtiendo a todas las bases
   let  decimal = parseInt($("#binary").val())
     
     // function hidetbn() {
         // Decimal a binario
             let decimalEnBinario = decimal.toString(2); // A la base 2
             $("#resultDaBinary").val(decimal, decimalEnBinario);
            console.log("El número decimal %s en binario es %s", decimal, decimalEnBinario);
         
             // Decimal a octal
             let decimalEnOctal = decimal.toString(8); // A la base 8
             $("#resultDaOct").val(decimal, decimalEnOctal);
             console.log("El número decimal %s en octal es %s", decimal, decimalEnOctal);
         
             // Decimal a hexadecimal
             let decimalEnHexadecimal = decimal.toString(16); // A la base 16
             $("#resultDaHexa").val(decimal, decimalEnHexadecimal)
             console.log("El número decimal %s en hexadecimal es %s", decimal, decimalEnHexadecimal);

    
}







// }

// function viewDiv() {
//     $("#resultDaBinary").css("style", "block")
//     $("#resultDaOct").css("style", "block")
//     $("#resultDaHexa").css("style", "block")
// }


// function BinaryD() {

//     // Binario a decimal
//     let binario = "1100"; // 12
//     let binarioEnDecimal = parseInt(binario, 2); // La base es 2
//     console.log("El número binario %s en decimal es %s", binario, binarioEnDecimal);

// }
// function OctalD() {
//     // Octal a decimal
//     let octal = "60"; // 48
//     let octalEnDecimal = parseInt(octal, 8); // La base es 8
//     console.log("El número octal %s en decimal es %s", octal, octalEnDecimal);
// }
// function HexadeD() {
//     // Hexadecimal a decimal
//     let hexadecimal = "FF"; // 255
//     let hexadecimalEnDecimal = parseInt(hexadecimal, 16); // La base es 16
//     console.log("El número hexadecimal %s en decimal es %s", hexadecimal, hexadecimalEnDecimal);
// }
