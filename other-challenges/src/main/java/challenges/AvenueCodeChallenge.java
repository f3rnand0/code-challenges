package technical.challenges;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;

public class AvenueCodeChallenge {

    class Category {
        private Integer id;
        private String name;
        private String keywords;
        private Integer parentId;
        private Integer level;

        public Category(Integer id, String name, String keywords, Integer parentId, Integer level) {
            this.id = id;
            this.name = name;
            this.keywords = keywords;
            this.parentId = parentId;
            this.level = level;
        }

        public String getKeywords() {
            return keywords;
        }

        public Integer getLevel() {
            return level;
        }

        public Integer getParentId() {
            return parentId;
        }
    }

    Map<Integer, Category> data = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(1, new Category(1, "Root", "Products", -1, 0)),
            new AbstractMap.SimpleEntry<>(2, new Category(2, "Furniture", "Furniture", 1, 1)),
            new AbstractMap.SimpleEntry<>(3, new Category(3, "Electronics", "Electronics, Gadgets", 1, 1)),
            new AbstractMap.SimpleEntry<>(4, new Category(4, "Home Appliances", "Home, Appliances", 1, 1)),
            new AbstractMap.SimpleEntry<>(5, new Category(5, "Major Appliances", "", 4, 2)),
            new AbstractMap.SimpleEntry<>(6, new Category(6, "Minor Appliances", "", 4, 2)),
            new AbstractMap.SimpleEntry<>(7, new Category(7, "Lawn & Garden", "Lawn, Garden", 4, 2)),
            new AbstractMap.SimpleEntry<>(8, new Category(8, "Kitchen Appliances", "", 5, 3)),
            new AbstractMap.SimpleEntry<>(9, new Category(9, "General Appliances", "", 5, 3))
            );

    public String[] solution(int categoryID) {
        String[] result = new String[]{"", ""};
        Category resultCategory = data.get(categoryID);
        if (resultCategory != null) {
            String keywords = resultCategory.getKeywords();
            Category tempCategory = resultCategory;
            while (keywords.isEmpty()) {
                tempCategory = data.get(tempCategory.getParentId());
                keywords = tempCategory.getKeywords();
            }
            result = new String[]{ resultCategory.getLevel().toString(), keywords };
        }
        return result;
    }

    public static void main(String[] args) {
        AvenueCodeChallenge avenueCodeChallenge = new AvenueCodeChallenge();
        System.out.println(Arrays.toString(avenueCodeChallenge.solution(3)));
        System.out.println(Arrays.toString(avenueCodeChallenge.solution(4)));
        System.out.println(Arrays.toString(avenueCodeChallenge.solution(6)));
        System.out.println(Arrays.toString(avenueCodeChallenge.solution(7)));
        System.out.println(Arrays.toString(avenueCodeChallenge.solution(8)));
        System.out.println(Arrays.toString(avenueCodeChallenge.solution(5)));
    }
}
