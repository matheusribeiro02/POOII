let golsBrasil = 1;
let golsAlemanha = 7;
let tentativas = 0;
let maxTentativas = 10;
let acertou = false;

document.querySelector(".palpite").addEventListener("click", () => {
  let palpiteBrasil = Number(document.querySelector(".placar-brasil").value);
  let palpiteAlemanha = Number(
    document.querySelector(".placar-alemanha").value
  );

  // Verifica se o palpite está correto
  if (palpiteBrasil == golsBrasil && palpiteAlemanha == golsAlemanha) {
    acertou = true;
    document.querySelector(".resultado").innerHTML = "ACERTOU!!!";
    document.querySelector(".placar-brasil").disabled = true;
    document.querySelector(".placar-alemanha").disabled = true;
    document.querySelector(".palpite").disabled = true;
  } else {
    tentativas++;
    if (tentativas >= maxTentativas) {
      // Acabaram as tentativas, o jogo termina
      document.querySelector(".resultado").innerHTML =
        "Fim de jogo! O placar correto era " +
        golsBrasil +
        " x " +
        golsAlemanha;
      document.querySelector(".placar-brasil").disabled = true;
      document.querySelector(".placar-alemanha").disabled = true;
      document.querySelector(".palpite").disabled = true;
    } else {
      let dicaBrasil =
        palpiteBrasil < golsBrasil ? "muito baixo" : "muito alto";
      if (palpiteBrasil == golsBrasil) {
        dicaBrasil = "correto";
      }
      let dicaAlemanha =
        palpiteAlemanha < golsAlemanha ? "muito baixo" : "muito alto";
      if (palpiteAlemanha == golsAlemanha) {
        dicaAlemanha = "correto";
      }

      document.querySelector(".resultado").innerHTML =
        "Tentativa " +
        tentativas +
        ": O palpite para o Brasil está " +
        dicaBrasil +
        " e o palpite para a Alemanha está " +
        dicaAlemanha;

      if (palpiteBrasil == "" || palpiteAlemanha == "") {
        tentativas = tentativas - 1;
        document.querySelector(".resultado").innerHTML =
          "Um dos palpites não foi preenchido...";
      }
    }
  }
});

document.querySelector(".reiniciar").addEventListener("click", () => {
  tentativas = 0;
  acertou = false;
  document.querySelector(".resultado").innerHTML = "";
  document.querySelector(".placar-brasil").value = "";
  document.querySelector(".placar-alemanha").value = "";
  document.querySelector(".placar-brasil").disabled = false;
  document.querySelector(".placar-alemanha").disabled = false;
  document.querySelector(".palpite").disabled = false;
});
