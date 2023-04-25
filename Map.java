import com.google.common.graph.*;

public class Map {
    
    public static void main(String[] args) {
        ImmutableGraph<String> myGraph = GraphBuilder.undirected()
        .<String>immutable()
        .putEdge{"Fairy Village", "Firefly Pond"}
        .putEdge{"Fairy Village", "Elf Treehouse"}
        .putEdge{"Elf Treehouse", "Firefly Pond"}
        .build();
    }
}
