const express = require ('express');

// FAKE DATABASE [Static DB] (Insert database here)
let people = [];                                                                     //Usando alocamento em RAM.

//CREATE APP
const app = express();

app.use (express.json());

//MIDDLEWARES
app.post('/people', (req, res) => {
    const { nome, dataNascimento, cpf, telefone, email } = req.body;
    const person = { nome, dataNascimento, cpf, telefone, email };                  //Criando o objeto "Pessoa".
    people.push (person);                                                           //Jogando o objeto que acabamos de criar dentro do DB (Array neste caso).
    return res.status (201).json (people);                                          //201 = Status de "Criado" retornando o objeto que acabamos de criar.
});

app.get('/people', (req, res) => {
    const allPeople = people;
    return res.status (200).json (allPeople);                                        //200 = Status de "Sucesso" retornando o objeto que acabamos de criar.
});

app.get('/people/:person_cpf', (req, res) => {
    const { person_cpf } = req.params;
    const person = people.find((person) => person.cpf === person_cpf);
    if (!person) res.status (404).json ("Não encontrado! Verifique o CPF inserido.");
    return res.status (200).json (person);                                          //200 = Status de "Sucesso" sendo retornado.
});

app.patch ('/people/:person_cpf', (req, res) => {
    const { nome, telefone, email } = req.body;                                     //Existe a possibilidade de "Update" desses três parâmetros.
    const { person_cpf } = req.params;
    const person = people.find ((person) => person.cpf === person_cpf)
    person.cpf = person.cpf;
    person.nome = nome ? nome : person.nome;                                        //SE um novo nome for inserido ele atualiza para o novo SENÃO permanece o que já estava.
    person.telefone = telefone ? telefone : person.telefone;                        //Mesma condição supracitada.
    person.email = email ? email : person.email;                                    //Mesma condição supracitada.
    return res.status (200).json (person);
})

app.delete ('/people/:person_cpf', (req, res) => {
    const { person_cpf } = req.params;                                              //Deleta pelo CPF cadastrado.
    const filteredPeople = people.filter ((person) => person.cpf !== person_cpf);   //Pessoas que o CPF diferentes do que eu passei como parÂmetro, são inseridas sentro da nova variável, e a que tem o CPF igual é deletada.
    people = filteredPeople;
    return res.status (204).json ("Deletado.");
})




//RUN SERVER
app.listen (3333, () => console.log ("Server is running."));