const endpoints = [
    'https://localhost:8080/api/VirtualPet/',
    'https://localhost:8080/api/Virtualpet/1',
    'https://localhost:8080/api/Virtualpet/2',
    'https://localhost:8080/api/Virtualpet/3',
    'https://localhost:8080/api/Virtualpet/4',
    'https://localhost:8080/api/Virtualpet/5',
    'https://localhost:8080/api/Virtualpet/6'
];

const onSuccess = response => {
    console.log(response);
}

const onFailure = error => {
    console.log(error);
}

console.log('initiating test...');
endpoints.forEach(request => {
    fetch(request).then(onSuccess).catch(onFailure);
})
console.log('all done!');
// alert("Hello I'm here.");
