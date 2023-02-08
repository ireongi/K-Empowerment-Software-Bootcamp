# 115p 과제
# 딕셔너리 key: 문자열 포켓몬 이름, value: 정수형 체력, 2차원 리스트로 새로운 값 추가시 바로 정렬 되도록 코드 작성

def find_and_insert_data(pokemon, hp):
    """
    포켓몬을 넣을 자리를 구하는 함수
    :param pokemon: 새로 입력받은 포켓몬의 이름 string
    :param hp: 새로 입력받은 포켓몬의 체력 integer
    :return:
    """
    find_idx = 1
    for i in range(0, len(pokemons)):
        pokemons_key = list(pokemons[i].values())
        if hp >= pokemons_key[0]:
            find_idx = i
            break

        if find_idx == 1:
            find_idx = len(pokemons)

    insert_data(find_idx, {pokemon: hp})


def insert_data(idx, pokemon):
    """
    포켓몬을 삽입하는 함수
    :param idx: 포켓몬을 넣을 위치 integer
    :param pokemon: 새로 입력받은 포켓몬의 이름과 체력 dictionary
    :return:
    """
    if idx < 0 or idx >= len(pokemons) + 1:
        print("Out of range!")

    pokemons.append(None)

    for i in range(len(pokemons) - 1, idx, -1):
        pokemons[i] = pokemons[i - 1]

    for i in range(0, len(pokemons)):
        if i == idx:
            pokemons[i] = pokemon


pokemons = [{'피카츄': 150}, {'라이츄': 130}, {'파이리': 110}, {'꼬부기': 100}, {'버터플': 80}]


if __name__ == "__main__":
    key = input("포켓몬 이름 : ")
    value = int(input("포켓몬 체력 : "))
    find_and_insert_data(key, value)

    print(pokemons)
