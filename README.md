# socket-java

## Resumo
Nos sistemas computacionais modernos está intrínseco o conceito de comunicação seja ela entre dispositivos ou entre processos destes, contudo quando se analisa tais conceitos a partir da ótica dos sistemas distribuídos é preciso levar em conta determinados fatores como Escalabilidade, segurança, transparência etc.
O projeto desenvolvido em questão trata-se de uma implementação com chat TCP/IP que aceita um número indeterminado de clientes e permite que estes troquem mensagens usando o servidor como nó central, ou seja uma implementação de um chat TCP/IP
Para garantir a estabilidade e escalabilidade o chat utiliza-se de processamento em paralelo, assim ao receber uma mensagem o mesmo a processa em uma thread individual e realiza o broadcast desta entre os usuários.
Além disso essas threads permitem o processamento do conteúdo da mensagem de forma independente garantindo a disponibilidade e um paralelismo maior. Tais técnicas são base fundamental para produtos reais como whatsapp,  Facebook Messenger, telegram e aplicativos de notificação.

