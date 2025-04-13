// Função para alternar entre temas
function toggleTheme() {
    const currentTheme = document.body.classList.contains('dark-theme') ? 'dark' : 'light';
    const newTheme = currentTheme === 'dark' ? 'light' : 'dark';
    document.body.classList.remove(`${currentTheme}-theme`);
    document.body.classList.add(`${newTheme}-theme`);

    // Salvar o tema no localStorage para persistência
    localStorage.setItem('theme', newTheme);
}

// Função para atualizar o status da TV
function updateStatus(status) {
    const statusElement = document.getElementById('status');
    statusElement.textContent = `Status: ${status}`;
}

// Função para enviar comandos para o back-end
function sendCommand(endpoint) {
    fetch(endpoint, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
    })
    .then(response => response.json())
    .then(data => {
        updateStatus(`TV ${data.ligada ? 'ligada' : 'desligada'}, Canal: ${data.canal}, Volume: ${data.volume}`);
    });
}

// Event listeners para botões
document.getElementById('ligar').addEventListener('click', () => sendCommand('/ligar'));
document.getElementById('desligar').addEventListener('click', () => sendCommand('/desligar'));
document.getElementById('canal-up').addEventListener('click', () => sendCommand('/canal/1'));
document.getElementById('canal-down').addEventListener('click', () => sendCommand('/canal/0'));
document.getElementById('volume-up').addEventListener('click', () => sendCommand('/volume/1'));
document.getElementById('volume-down').addEventListener('click', () => sendCommand('/volume/0'));

// Alternar tema ao clicar no botão
document.getElementById('toggle-theme').addEventListener('click', toggleTheme);

// Carregar tema do localStorage
const savedTheme = localStorage.getItem('theme');
if (savedTheme) {
    document.body.classList.add(`${savedTheme}-theme`);
} else {
    document.body.classList.add('light-theme');
}
