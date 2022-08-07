class SqueakyClean
{
    static String clean(String identifier)
    {
        // kebab-case to camelCase:
        if (identifier.contains("-")) {
            String[] noSkewer = identifier.split("-");
            identifier = noSkewer[0];
            for (int i = 1; i < noSkewer.length; i++) {
                identifier += (
                    noSkewer[i].substring(0, 1).toUpperCase()
                    + noSkewer[i].substring(1)
                );
            }
        }
        return identifier
               .replace(' ', '_')
               .replaceAll("\\p{Cntrl}", "CTRL")
               .replaceAll("[^\\p{L}|_]", "")
               .replaceAll("[\u03B1-\u03C9]", "");
    }
}
