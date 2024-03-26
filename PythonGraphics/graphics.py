import matplotlib.pyplot as plt
boyutlar = [85900, 4461, 783, 100, 51]
calisma_sureleri = [128.3, 0.820, 0.091, 0.019, 0.013]
plt.figure(figsize=(10, 6))
plt.plot(boyutlar, calisma_sureleri, marker='o', linestyle='-')
plt.title('TSP Problemi İçin Boyuta Göre Çalışma Süresi')
plt.xlabel('Şehir Sayısı')
plt.ylabel('Çalışma Süresi (s)')
plt.grid(True)
plt.xscale('log')
plt.yscale('log')
plt.xticks(boyutlar)
for i in range(len(boyutlar)):
    plt.text(boyutlar[i], calisma_sureleri[i], f'({boyutlar[i]}, {calisma_sureleri[i]})', fontsize=8)
plt.tight_layout()
plt.show()