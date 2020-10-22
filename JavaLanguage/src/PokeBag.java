import java.util.ArrayList;
import java.util.HashMap;

public class PokeBag {
    // 이름을 넣으면 해당 이름을 가진 포켓몬리스트를 짝진 HashMap
    private final HashMap<String, ArrayList<Pokemon>> pokemons = new HashMap<String, ArrayList<Pokemon>>();

    // 이름을 넣으면 해당 이름을 가진 포켓몬리스트를 반환
    public ArrayList<Pokemon> getPokemons(String name) {
        return pokemons.get(name);
    }

    // 포켄몬을 인수로 받고 해당이름과 이름을 가진 리스트를 포켓백의 HashMap에 넣어주는 함수
    public void add(Pokemon pokemon) {
        // 해당 포켓몬을 가진 포켓몬 리스트가 없다면
        if (getPokemons(pokemon.name) == null) {
            // 이름을 가진 포켓몬 리스트 객체를 생성하고 포켓몬 HashMap에 추가한다.
            ArrayList<Pokemon> samePokemonList = new ArrayList<>();
            samePokemonList.add(pokemon);
            pokemons.put(pokemon.name, samePokemonList);
        }else {
            // 해당 포켓몬을 가진 포켓몬 리스트가 있다면 포켓몬 HashMap에 이름과 리스트를 짝지어 저장한다.
            pokemons.put(pokemon.name, getPokemons(pokemon.name));
        }
    }

    // 포켓몬 이름을 가진 것중 가장 센 포켓몬을 반환하는 함수
    public Pokemon getStrongest(String name) {
        // 해당이름을 가진 포켓몬리스트중 첫번째 포켓몬
        if (pokemons.get(name) == null) {
            return null;
        }
        Pokemon strongPokemon = new Pokemon(name, 0);
        // 포켓몬 리스트에서 하나씩 포켓몬 대결해본다.
        // 만약 찾고자 하는 포켓몬이 없다면?
        for (int i = 0; i < pokemons.size(); i++) {
            for (Pokemon pokemon : pokemons.get(name)) {
                // 포켓몬 cp가 높다면 센 포켓몬이 바뀐다.
                if (strongPokemon.cp < pokemon.cp) {
                    strongPokemon = pokemon;
                }
            }

        }
        // 가장 센 포켓몬 반환
        return strongPokemon;
    }

    public Pokemon getStrongest() {
        Pokemon strongPokemon = new Pokemon("", 0);
        // 모든 포켓몬 이름들을 하나씩 꺼내보자
        for (String name : pokemons.keySet()) {
            // 꺼낸 포켓몬 이름을 가진 포켓몬 리스트 중 가장 강한 포켓몬을 뽑고 다시 붙어보자.
            if (getStrongest(name) == null){
                continue;
            }else {
                if (strongPokemon.cp < getStrongest(name).cp) {
                    strongPokemon = getStrongest(name);
                }
            }
        }
        return strongPokemon;
    }
}